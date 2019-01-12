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
@Table(name = "platform_role_menu", catalog = "pmss")
public class PlatformRoleMenu implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3370874754270403729L;
	private String id;
	private String roleId;
	private String menuId;
	private Date createTime;

	public PlatformRoleMenu() {
	}

	public PlatformRoleMenu(String id, String roleId, String menuId) {
		this.id = id;
		this.roleId = roleId;
		this.menuId = menuId;
	}

	public PlatformRoleMenu(String id, String roleId, String menuId, Date createTime) {
		this.id = id;
		this.roleId = roleId;
		this.menuId = menuId;
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

	@Column(name = "menu_id", nullable = false, length = 50)
	public String getMenuId() {
		return this.menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
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
