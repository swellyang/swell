package com.swell.code.platform.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
/**
 * @author fei.yang
 */
@Entity
@Table(name = "platform_role_resource", catalog = "pmss")
public class PlatformRoleResource implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4769333289286717495L;
	private String id;
	private String roleId;
	private String resourceId;
	private Date createTime;

	public PlatformRoleResource() {
	}

	public PlatformRoleResource(String id, String roleId, String resourceId) {
		this.id = id;
		this.roleId = roleId;
		this.resourceId = resourceId;
	}

	public PlatformRoleResource(String id, String roleId, String resourceId, Date createTime) {
		this.id = id;
		this.roleId = roleId;
		this.resourceId = resourceId;
		this.createTime = createTime;
	}

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 50)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "role_id", nullable = false, length = 50)
	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Column(name = "resource_id", nullable = false, length = 50)
	public String getResourceId() {
		return this.resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
