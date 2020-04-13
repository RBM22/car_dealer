package com.rbm.carDealer.mappers;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;


/**
 * Created by rakshabm on 2020-04-12
 **/
public class SQLBuilder {

    //name, manufacturerName,model,manufacturingYear,color
    public static String buildFindByDynamicFilter( final @Param( "name" ) String name,
            final @Param( "manufacturerName" ) String manufacturerName, final @Param("model") String model,
            final @Param("manufacturingYear") String manufacturingYear, final @Param("color") String color )
    {
        return new SQL() {

            {
                SELECT("*");
                FROM("car");
                if( name != null )
                {
                    OR().WHERE("name like #{name} || '%'");
                }
                if( manufacturerName != null )
                {
                    OR().WHERE("manufacturerName like #{manufacturerName}");
                }
                if( model != null )
                {
                    OR().WHERE("model like #{model} || '%'");
                }
                if( manufacturingYear != null )
                {
                    OR().WHERE("manufacturingYear like #{manufacturingYear} || '%'");
                }
                if( color != null )
                {
                    OR().WHERE("color like #{color} || '%'");
                }
            }
        }.toString();
    }

    public String updateDynamicFilter(final @Param( "name" ) String name,
            final @Param( "manufacturerName" ) String manufacturerName, final @Param("model") String model,
            final @Param("manufacturingYear") String manufacturingYear, final @Param("color") String color ,final @Param("id") Integer id ){
        return new SQL() {

            {
                UPDATE("car");
                if( name != null )
                {
                    OR().SET("name = #{name}");
                }
                if( manufacturerName != null )
                {
                    OR().SET("manufacturerName = #{manufacturerName}");
                }
                if( model != null )
                {
                    OR().SET("model = #{model} ");
                }
                if( manufacturingYear != null )
                {
                    OR().SET("manufacturingYear = #{manufacturingYear} ");
                }
                if( color != null )
                {
                    OR().SET("color = #{color}");
                }
                WHERE("id = #{id}");
            }
        }.toString();

    }
}
