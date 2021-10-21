package com.imooc.mgallery.dao;

import com.imooc.mgallery.entity.Painting;
import com.imooc.mgallery.utils.PageModel;
import com.imooc.mgallery.utils.XmlDataSource;

import java.util.List;

public class PaintingDao {
    public PageModel pagination(int page, int row) {
        List<Painting> list = XmlDataSource.getData();
        //PageModel分页处理得到分页数据以及分页附加
        PageModel pageModel = new PageModel(page, row, list);
        return pageModel;
    }
    
}
