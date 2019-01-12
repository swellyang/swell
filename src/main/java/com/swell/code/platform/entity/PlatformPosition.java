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
 * @desc 岗位
 */
@Entity
@Table(name = "platform_position", catalog = "pmss")
public class PlatformPosition implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -5006228650563762687L;

	private String id;// 主键ID
	private String code;// 代码
	private String name;// 名称
	private String shortName;// 简称
	private String departentId;// 部门ID
	private Integer status;// 状态
	private Date createTime;// 创建时间

	public PlatformPosition() {
	}

	public PlatformPosition(String id) {
		this.id = id;
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

	@Column(name = "code", length = 50)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "name", length = 200)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "short_name", length = 50)
	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	@Column(name = "department_id", length = 50)
	public String getDepartmentId() {
		return departentId;
	}

	public void setDepartmentId(String departentId) {
		this.departentId = departentId;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
