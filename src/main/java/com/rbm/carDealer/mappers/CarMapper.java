package com.rbm.carDealer.mappers;

import com.rbm.carDealer.models.Car;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by rakshabm on 2020-04-11
 **/
@Mapper public interface CarMapper {

    @Select( "select * from car" ) List<Car> findAll();

    @Select( "select * from car WHERE name=#{name}" ) List<Car> findByName( String name );

    @Select( "select * from car WHERE id=#{id}" ) Optional<Car> findById( Integer id );

    @Insert( "insert into car(name, manufacturerName,model,manufacturingYear,color) values(#{name}, #{manufacturerName},#{model},#{manufacturingYear},#{color})" ) @SelectKey( statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class ) void insert(
            Car car );

    @SelectProvider( type = SQLBuilder.class, method = "buildFindByDynamicFilter" ) List<Car> findByDynamicFilter(
            @Param( "name" ) String name, @Param( "manufacturerName" ) String manufacturerName,
            @Param( "model" ) String model, @Param( "manufacturingYear" ) String manufacturingYear,
            @Param( "color" ) String color );

    @UpdateProvider( type = SQLBuilder.class, method = "updateDynamicFilter" ) void update( @Param( "name" ) String name,
            @Param( "manufacturerName" ) String manufacturerName, @Param("model") String model,
            @Param("manufacturingYear") String manufacturingYear, @Param("color") String color, @Param("id") Integer id  );

    @Delete( "delete from car where id=#{id}" ) void delete( Car car );

}
