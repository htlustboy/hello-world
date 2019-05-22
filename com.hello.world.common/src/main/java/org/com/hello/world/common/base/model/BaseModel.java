package org.com.hello.world.common.base.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class BaseModel extends AbstractModel implements Serializable{
	
	@Version
	@Column(name="version")
	private int version;
	
	@Column(name="is_enable")
	private boolean isEnable;
	
	@Column(name="is_delete")
	private boolean isDelete;
}
