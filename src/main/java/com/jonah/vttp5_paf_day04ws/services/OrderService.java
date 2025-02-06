package com.jonah.vttp5_paf_day04ws.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jonah.vttp5_paf_day04ws.models.OrderPage;
import com.jonah.vttp5_paf_day04ws.repos.OrderRepo;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;


    public void writeToOrder(OrderPage op){
        orderRepo.addOrder(op);
    }

    public void writeToDetail(OrderPage op){
        orderRepo.addDetail(op);
    }


    @Transactional
    public void writeOrderPage(OrderPage op){
        op.setOrder_date(LocalDate.now());

        int orderId = orderRepo.addOrderWithKeyholder(op);
        //orderRepo.addOrder(op);
        op.setOrder_id(orderId);
        orderRepo.addDetail(op);
    }

    
}
