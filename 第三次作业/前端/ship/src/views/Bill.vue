<template>
    <div>
      <el-table :data="orders" border class="custom-table">
        <el-table-column  label="序号" width="80">
        <template slot-scope="scope">
          {{ scope.$index + 1 }}
        </template>
      </el-table-column>
        <el-table-column prop="shiporderid" label="Ship Order ID" ></el-table-column>
        <el-table-column prop="positionstart" label="Position Start"></el-table-column>
        <el-table-column prop="positionend" label="Position End"></el-table-column>
        <el-table-column label="查询">
        <template slot-scope="scope">
          <el-button type="text" class="query-button" @click="handleQuery(scope.row)">查 询</el-button>
        </template>
      </el-table-column>
      </el-table>
      <div>
      <el-dialog :visible="showDialog" title="信息窗口" @close="closeDialog">
      <p>{{ message }}</p>
    </el-dialog>
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
            message: ''
        };
    },
    mounted() {
        this.getAllOrders();
    },
    methods: {
      //查询订单价格
    handleQuery(row) {
      // 处理查询点击事件，可以使用 row 中的数据进行相关操作/*
      axios.post('http://localhost:9999/ShipOrder/retrieveBill',{ "shiporderid": row.shiporderid },{
            headers: {
                Authorization: this.$store.state.token
            }
        }).then(response => {
            console.log(response.data)
            if (response.data.msg == "查询成功") {

                console.log(response.data)
                this.message = "orderid 为"+row.shiporderid+"的订单， bill 为"+ response.data.bill
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
    getAllOrders(){
              // 向后端发送请求获取数据，假设接口返回的数据是 allOrder
        this.id = this.$store.state.id;
        console.log(this.id)
        //token = this.$store.state.token;
      
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
    openDialog() {
      // 在这里设置要显示的信息内容
      this.showDialog = true;
    },
    closeDialog() {
      this.showDialog = false;
    }
  }
};
</script>
  

  
<style scoped>
.custom-table {
  width: 100%;
  border-collapse: collapse;
}


.query-button{
    color: blue !important;
    text-decoration: underline
}

.query-button :hover{
    color: rgb(153, 255, 0) !important;
    text-decoration: underline
}
</style>
  