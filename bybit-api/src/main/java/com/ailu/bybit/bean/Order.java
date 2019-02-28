package com.ailu.bybit.bean;

import com.google.gson.Gson;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * NOTE:
 * OneToken 订单列表
 * {
 * 'order_id': 'string',  UUID类型订单唯一ID
 * 'user_id': 0,   用户ID
 * 'symbol': 'string', 产品类型
 * 'side': 'string',   购买方向
 * 'order_type': 'string', 订单类型
 * 'price': 0,   委托价格
 * 'qty': 0,   委托数量
 * 'time_in_force': 'string', 执行策略
 * 'order_status': 'string', 委托状态: Created:创建订单;Rejected:订单被拒绝;New:订单待成交;PartiallyFilled:订单部分成交;Filled:订单全部成交,Cancelled:订单被取消
 * 'last_exec_time': 0.000000, 最近一次成交时间
 * 'last_exec_price': 0,  最近一次成交价格
 * 'leaves_qty': 0,  剩余委托数量
 * 'cum_exec_qty': 0, 累计成交数量
 * 'cum_exec_value': 0, 累计成交的名义价值
 * 'cum_exec_fee': 0,   累计已成交手续费
 * 'reject_reason': 'string', 被拒单的原因
 * 'order_link_id': 'string',机构自定义订单ID
 * 'created_at':'2018-10-15T04:12:19.000Z',
 * 'updated_at':'2018-10-15T04:12:19.000Z',
 * }
 *
 * @Version 1.0
 * @Since JDK1.8
 * @Author mr.wang
 * @Company Henan ailu
 * @Date 2018/12/13 17:31
 */
@Data
public class Order {

    /**
     * order_id : string
     * user_id : 0
     * symbol : string
     * side : string
     * order_type : string
     * price : 0
     * qty : 0
     * time_in_force : string
     * order_status : string
     * last_exec_time : 0
     * last_exec_price : 0
     * leaves_qty : 0
     * cum_exec_qty : 0
     * cum_exec_value : 0
     * cum_exec_fee : 0
     * reject_reason : string
     * order_link_id : string
     * created_at : 2018-10-15T04:12:19.000Z
     * updated_at : 2018-10-15T04:12:19.000Z
     */

    private String order_id;
    private Long user_id;
    private String symbol;
    private String side;
    private String order_type;
    private BigDecimal price;
    private BigDecimal qty;
    private String time_in_force;
    private String order_status;
    private Double last_exec_time;
    private BigDecimal last_exec_price;
    private BigDecimal leaves_qty;
    private BigDecimal cum_exec_qty;
    private BigDecimal cum_exec_value;
    private BigDecimal cum_exec_fee;
    private String reject_reason;
    private String order_link_id;
    private Date created_at;
    private Date updated_at;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public String getTime_in_force() {
        return time_in_force;
    }

    public void setTime_in_force(String time_in_force) {
        this.time_in_force = time_in_force;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public Double getLast_exec_time() {
        return last_exec_time;
    }

    public void setLast_exec_time(Double last_exec_time) {
        this.last_exec_time = last_exec_time;
    }

    public BigDecimal getLast_exec_price() {
        return last_exec_price;
    }

    public void setLast_exec_price(BigDecimal last_exec_price) {
        this.last_exec_price = last_exec_price;
    }

    public BigDecimal getLeaves_qty() {
        return leaves_qty;
    }

    public void setLeaves_qty(BigDecimal leaves_qty) {
        this.leaves_qty = leaves_qty;
    }

    public BigDecimal getCum_exec_qty() {
        return cum_exec_qty;
    }

    public void setCum_exec_qty(BigDecimal cum_exec_qty) {
        this.cum_exec_qty = cum_exec_qty;
    }

    public BigDecimal getCum_exec_value() {
        return cum_exec_value;
    }

    public void setCum_exec_value(BigDecimal cum_exec_value) {
        this.cum_exec_value = cum_exec_value;
    }

    public BigDecimal getCum_exec_fee() {
        return cum_exec_fee;
    }

    public void setCum_exec_fee(BigDecimal cum_exec_fee) {
        this.cum_exec_fee = cum_exec_fee;
    }

    public String getReject_reason() {
        return reject_reason;
    }

    public void setReject_reason(String reject_reason) {
        this.reject_reason = reject_reason;
    }

    public String getOrder_link_id() {
        return order_link_id;
    }

    public void setOrder_link_id(String order_link_id) {
        this.order_link_id = order_link_id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
