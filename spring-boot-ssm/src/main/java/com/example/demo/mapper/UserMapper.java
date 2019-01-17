package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.bean.User;

//告诉MyBatis这是一个操作数据库的Mapper
@Mapper
public interface UserMapper {

	@Select("select * from t_user where id=#{id}")
	public User getUser(Integer id);
}
