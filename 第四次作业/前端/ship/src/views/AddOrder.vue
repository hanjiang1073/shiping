<template>
    <div class="container">
        <div class="table-container">
            <el-table :data="orders" border class="custom-table">
                <el-table-column label="序号" width="80">
                    <template slot-scope="scope">
                        {{ scope.$index + 1 }}
                    </template>
                </el-table-column>
                <el-table-column prop="shiporderid" label="Ship Order ID"></el-table-column>
                <el-table-column prop="positionstart" label="Position Start"></el-table-column>
                <el-table-column prop="positionend" label="Position End"></el-table-column>
            </el-table>
        </div>
        <div class="form-container">
            <el-form label-position="top" class="form">
                <el-form-item label="Position Start">
                    <el-input v-model="positionStart"></el-input>
                </el-form-item>
                <el-form-item label="Position End">
                    <el-input v-model="positionEnd"></el-input>
                </el-form-item>
                <el-button type="primary" @click="createOrder">创建订单</el-button>
            </el-form>
        </div>
    </div>
</template>


<script>
import axios from 'axios'
export default {
    data() {
        return {
            id: 0,
            orders: [],
            showDialog: false,
            message: '',
            positionStart: '',
            positionEnd: '',
        };
    },
    mounted() {
        this.getAllOrders();
    },
    methods: {
        //查询订单价格
        handleQuery(row) {
            // 处理查询点击事件，可以使用 row 中的数据进行相关操作/*
            console.log(this.$store.state.token)
            axios.post('http://localhost:9999/ShipOrder/retrieveBill', { "shiporderid": row.shiporderid }, {
                headers: {
                    Authorization: this.$store.state.token
                }
            }).then(response => {
                console.log(response.data)
                if (response.data.msg == "查询成功") {

                    console.log(response.data)
                    this.message = "orderid 为" + row.shiporderid + "的订单， bill 为" + response.data.bill
                    this.openDialog()

                }
                else {
                    this.$message.error("用户ID或密码错误")
                }
            }).catch(error => {
                console.log(error)
            })



            console.log('查询点击事件', row.shiporderid);
            // 进行其他逻辑操作...
        },
        //获取所有订单信息
        getAllOrders() {
            // 向后端发送请求获取数据，假设接口返回的数据是 allOrder
            this.id = this.$store.state.id;
            console.log(this.id)
            //token = this.$store.state.token;
            console.log(this.$store.state.token)
            axios.get('http://localhost:9999/ShipOrder/getOrders', {
                headers: {
                    Authorization: this.$store.state.token
                }
            }).then(response => {
                console.log(response.data)
                if (response.data.msg == "查询成功") {

                    this.orders = response.data.allOrder;

                }
                else {
                    this.$message.success("没有订单哦~")
                }
            }).catch(error => {
                console.log(error)
            })
        },
        createOrder() {
            axios.post('http://localhost:9999/ShipOrder/createOrder', {
                "positionstart": this.positionStart,
                "positionend": this.positionEnd
            }, {
                headers: {
                    Authorization: this.$store.state.token
                }
            }).then(response => {
                console.log(response.data)
                if (response.data.msg == "添加成功") {

                    this.$message.success("添加成功~")
                    this.getAllOrders()

                }
                else {
                    this.$message.success("没有订单哦~")
                }
            }).catch(error => {
                console.log(error)
            })
        },
    }
}
</script>


<style>
.container {
    display: flex;
    flex-direction: column;
    align-items: center;
    max-width: 600px;
    margin: 0 auto;

}

.table-container {
    background-color: #f5f5f5;
    width: 100%;
    padding: 20px;
    margin-bottom: 20px;
}

.custom-table {
    width: 100%;
}

.form-container {
    background-color: #f5f5f5;
    padding: 20px;
    border-radius: 4px;
    width: 100%;
}

.form-item {
    margin-bottom: 20px;
}
</style>