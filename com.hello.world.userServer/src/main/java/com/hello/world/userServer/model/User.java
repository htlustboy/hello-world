package com.hello.world.userServer.model;

import javax.persistence.Column;
import javax.persistence.Table;

import com.hello.world.common.base.model.BaseModel;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author ht
 *
 */
@Data
@Accessors(chain=true)
@Table(name="hw_user")
public class User extends BaseModel{
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="display_name")
	private String displayName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="country")
	private String country;
	
	@Column(name="province")
	private String province;
	
	@Column(name="city")
	private String city;
	
	@Column(name="distinct")
	private String distinct;
	
	@Column(name="address")
	private String address;
	
	@Column(name="age")
	private Integer age;
	
	@Column(name="sex")
	private Integer sex;
	
	@Column(name="level")
	private Integer level;
	
}
