package com.imooc.mgallery.service;

import com.imooc.mgallery.dao.PaintingDao;
import com.imooc.mgallery.entity.Painting;
import com.imooc.mgallery.utils.PageModel;

import java.util.List;

public class PaintingService {
    private PaintingDao paintingDao = new PaintingDao();

    public PageModel pagination(int page, int row) {
        if (row == 0) {
            throw new RuntimeException("无效的rows参数");
        }
        return paintingDao.pagination(page, row);
    }

    public static void main(String[] args) {
        PaintingService paintingService = new PaintingService();
        PageModel pageModel = paintingService.pagination(2, 6);
        List<Painting> paintingList = pageModel.getPageData();
        for (Painting painting : paintingList) {
            System.out.println(painting.getPname());
        }
        System.out.println(pageModel.getPageStartRow() + ":" + pageModel.getPageEndRow());
    }
}
