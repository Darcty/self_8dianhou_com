package com.visionet.project.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;

@MappedSuperclass
public class BasePo  implements Persistable<Integer>{
	
	private static final long serialVersionUID = -5477123624657570484L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
//	@CreatedDate
//	@Column(updatable=false)
//	private Date createDate;
//	@LastModifiedDate
//	private Date updateDate;
//	@CreatedBy
//	@Column(updatable=false)
//	private String createBy;
//	@LastModifiedBy
//	private String updateBy;

//	private Integer isDel = 0;

//	public String getCreateBy() {
//		return createBy;
//	}
//
//	public void setCreateBy(String createBy) {
//		this.createBy = createBy;
//	}
//
//	public String getUpdateBy() {
//		return updateBy;
//	}
//
//	public void setUpdateBy(String updateBy) {
//		this.updateBy = updateBy;
//	}
//
//	public Integer getIsDel() {
//		return isDel;
//	}
//
//	public void setIsDel(Integer isDel) {
//		this.isDel = isDel;
//	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	public Date getCreateDate() {
//		return createDate;
//	}
//
//	public void setCreateDate(Date createDate) {
//		this.createDate = createDate;
//	}
//
//	public Date getUpdateDate() {
//		return updateDate;
//	}
//
//	public void setUpdateDate(Date updateDate) {
//		this.updateDate = updateDate;
//	}

	/* (non-Javadoc)
	 * @see org.springframework.data.domain.Persistable#isNew()
	 */
	@Override
	public boolean isNew() {
		return null == getId();
	}
}
