package com.hello.world.common.base.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
public abstract class AbstractModel implements Serializable{
	
	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="create_time")
	private Date createTime;
	
	@Column(name="create_user")
	private String createUser;
	
	@Column(name="update_time")
	private Date updateTime;
	
	@Column(name="update_user")
	private String updateUser;
	
}
