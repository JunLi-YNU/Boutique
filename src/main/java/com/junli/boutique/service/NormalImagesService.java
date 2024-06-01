package com.junli.boutique.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.junli.boutique.domain.NormalImages;

/**
* @author junli
* @description 针对表【normal_images(用户图片表)】的数据库操作Service
* @createDate 2023-08-05 12:57:05
*/
public interface NormalImagesService extends IService<NormalImages> {

    int getNormalUserImage();

}
