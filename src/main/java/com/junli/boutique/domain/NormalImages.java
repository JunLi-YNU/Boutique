package com.junli.boutique.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 用户图片表
 * @TableName normal_images
 */
@TableName(value ="normal_images")
@Data
public class NormalImages implements Serializable {
    /**
     * 图片ID
     */
    @TableId(value = "image_id", type = IdType.AUTO)
    private Integer imageId;

    /**
     * 图片的拥有者
     */
    @TableField(value = "image_user_id")
    private Long imageUserId;

    /**
     * 图片名称
     */
    @TableField(value = "image_name")
    private String imageName;

    /**
     * 图片类型（1、BMP 2、TIFF 3、GIF 4、PNG 5、JPEG)
     */
    @TableField(value = "image_type")
    private String imageType;

    /**
     * 图片的存储地址
     */
    @TableField(value = "image_url")
    private String imageUrl;

    /**
     * 图片的上传时间
     */
    @TableField(value = "image_upload_time")
    private LocalDateTime imageUploadTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        NormalImages other = (NormalImages) that;
        return (this.getImageId() == null ? other.getImageId() == null : this.getImageId().equals(other.getImageId()))
            && (this.getImageUserId() == null ? other.getImageUserId() == null : this.getImageUserId().equals(other.getImageUserId()))
            && (this.getImageName() == null ? other.getImageName() == null : this.getImageName().equals(other.getImageName()))
            && (this.getImageType() == null ? other.getImageType() == null : this.getImageType().equals(other.getImageType()))
            && (this.getImageUrl() == null ? other.getImageUrl() == null : this.getImageUrl().equals(other.getImageUrl()))
            && (this.getImageUploadTime() == null ? other.getImageUploadTime() == null : this.getImageUploadTime().equals(other.getImageUploadTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getImageId() == null) ? 0 : getImageId().hashCode());
        result = prime * result + ((getImageUserId() == null) ? 0 : getImageUserId().hashCode());
        result = prime * result + ((getImageName() == null) ? 0 : getImageName().hashCode());
        result = prime * result + ((getImageType() == null) ? 0 : getImageType().hashCode());
        result = prime * result + ((getImageUrl() == null) ? 0 : getImageUrl().hashCode());
        result = prime * result + ((getImageUploadTime() == null) ? 0 : getImageUploadTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", imageId=").append(imageId);
        sb.append(", imageUserId=").append(imageUserId);
        sb.append(", imageName=").append(imageName);
        sb.append(", imageType=").append(imageType);
        sb.append(", imageUrl=").append(imageUrl);
        sb.append(", imageUploadTime=").append(imageUploadTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}