package com.example.procedure.service;

import com.example.procedure.bean.SaleQuery;

import java.util.List;

public interface SaleQueryService {
    List<SaleQuery> findSaleQueryProc(String begin_date, String end_date, String type, String inventoryList);
}
