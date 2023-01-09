package com.mingxinbeijing.dao.model;

import java.io.Serializable;
import java.util.Date;

public class Category implements Serializable {
    private Integer id;
    /**
     * 分类ID
     *
     * @mbg.generated
     */
    private Long categoryId;

    /**
     * 名称
     *
     * @mbg.generated
     */
    private String categoryName;

    /**
     * 父分类id，一级分类默认父分类0
     *
     * @mbg.generated
     */
    private Long parentId;

    /**
     * 分类级别
     *
     * @mbg.generated
     */
    private Byte level;

    /**
     * 排序权重 数越大权重越高
     *
     * @mbg.generated
     */
    private Integer weightSort;

    /**
     * 是否删除 0-正常 1-删除
     *
     * @mbg.generated
     */
    private Byte isDeleted;

    /**
     * 状态: 0-正常
     *
     * @mbg.generated
     */
    private Byte status;

    /**
     * 版本
     *
     * @mbg.generated
     */
    private Long versions;

    /**
     * 扩展属性json
     *
     * @mbg.generated
     */
    private String features;

    /**
     * 备注
     *
     * @mbg.generated
     */
    private String remarks;

    /**
     * 创建人id
     *
     * @mbg.generated
     */
    private Long createId;

    /**
     * 更新人id
     *
     * @mbg.generated
     */
    private Long updateId;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * 更新时间
     *
     * @mbg.generated
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public Integer getWeightSort() {
        return weightSort;
    }

    public void setWeightSort(Integer weightSort) {
        this.weightSort = weightSort;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getVersions() {
        return versions;
    }

    public void setVersions(Long versions) {
        this.versions = versions;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public Long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", categoryName=").append(categoryName);
        sb.append(", parentId=").append(parentId);
        sb.append(", level=").append(level);
        sb.append(", weightSort=").append(weightSort);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", status=").append(status);
        sb.append(", versions=").append(versions);
        sb.append(", features=").append(features);
        sb.append(", remarks=").append(remarks);
        sb.append(", createId=").append(createId);
        sb.append(", updateId=").append(updateId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}