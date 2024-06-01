package com.junli.boutique.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.junli.boutique.domain.NormalImages;
import com.junli.boutique.service.NormalImagesService;
import com.junli.boutique.mapper.NormalImagesMapper;
import org.springframework.stereotype.Service;

/**
* @author junli
* @description 针对表【normal_images(用户图片表)】的数据库操作Service实现
* @createDate 2023-08-05 12:57:05
*/
@Service
public class NormalImagesServiceImpl extends ServiceImpl<NormalImagesMapper, NormalImages>
    implements NormalImagesService{

    @Override
    public int getNormalUserImage() {
        return 0;
    }
}




