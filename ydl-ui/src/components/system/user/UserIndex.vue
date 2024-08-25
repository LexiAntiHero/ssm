<template>
  <el-form :inline="true" :model="queryParam" class="demo-form-inline">
    <el-form-item label="User Name">
      <el-input v-model="queryParam.userName" placeholder="username" clearable />
    </el-form-item>
    <el-form-item label="Nick Name">
      <el-input v-model="queryParam.nickName" placeholder="nick name" clearable />
    </el-form-item>
    <!-- <el-form-item label="Activity time">
      <el-date-picker
        v-model="formInline.date"
        type="date"
        placeholder="Pick a date"
        clearable
      />
    </el-form-item> -->
    <el-form-item>
      <el-button type="primary" @click="onSubmit">Query</el-button>
    </el-form-item>
  </el-form>
  <div>
    <el-button type="primary" :icon="Plus" @click="create"/>
    <el-button type="primary" :icon="Share" />
    <el-button type="primary" :icon="Delete" />
    <el-button type="primary" :icon="Search">Search</el-button>
    <el-button type="primary">
      Upload<el-icon class="el-icon--right"><Upload /></el-icon>
    </el-button>
  </div>
    <el-table ref="tableRef" row-key="userName" :data="tableData" style="width: 100%">
      <el-table-column prop="userName" label="Name" />
      <el-table-column prop="nickName" label="NickName" />
      <el-table-column prop="email" label="e-mail" />
      <el-table-column label="Operations"> <template #default="scope"> <el-button size="small" @click="handleEdit(scope.$index, scope.row)"> Edit </el-button> <el-button size="small" type="danger" @click="handleDelete(scope.$index, scope.row)" > Delete </el-button> </template> </el-table-column>
    </el-table>
    <el-pagination background layout="prev, pager, next" @current-change="changePage" :total="total" :page-size="queryParam.size"/>

  <el-dialog v-model="dialogVisiable" :title="title" width="30%">
      <el-form ref="userFormRef" :model="userForm" lable-width="120px">
        <el-form-item label="User name">
            <el-input v-model="userForm.userName"></el-input>
        </el-form-item>
        <el-form-item label="Nick name">
            <el-input v-model="userForm.nickName"></el-input>
        </el-form-item>
        <el-form-item label="Password" v-if="userForm.userId === null">
            <el-input v-model="userForm.password" ></el-input>
        </el-form-item>
        <el-form-item label="Confirm Password" v-if="userForm.userId === null">
            <el-input v-model="userForm.confirmPassword"></el-input>
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogVisiable = false">Cancel</el-button>
          <el-button type="primary" @click="submitForm">Submit</el-button>
        </span>
      </template>
    </el-dialog>

  </template>
  
  <script setup>
  import { ref } from 'vue'
  import { listUser, add, getById, update, deleteUser} from '@/api/user'
  import { onMounted } from 'vue';
  import { Delete, Plus, Search, Share, Upload } from '@element-plus/icons-vue'
  import { ElMessage, ElMessageBox } from 'element-plus'

  let dialogVisiable = ref(false);
  
  const queryParam = ref({
    size: 2,
    page: 0,
    userName: '',
    nickName: ''
  });

  let userForm = ref({
    userId:null,
    userName:'',
    nickName:'',
    password:'',
    confirmPassword:''
  })

  const tableData = ref ([])
  const total = ref(0);
  let title = ref("add a user")

  const getList = function() {
      listUser(queryParam.value).then(res => {
          tableData.value = res.data.content;
          total.value = res.data.totalElements;
          queryParam.value.size = res.data.size;
    })
  }
  onMounted(() => {
    getList();
  })
  
  const changePage = async function(c) {
    queryParam.value.page = c - 1;
    getList();
  }
  const onSubmit = function(){
    getList();
  };

  const submitForm = function(){
      delete userForm.value.confirmPassword;
      if (userForm.value.userId === null) {
          add(userForm.value).then(res => {
          console.log(res);
          dialogVisiable.value = false;
        })
        getList();
      } else {
        update(userForm.value).then(res => {
          if(res.status === 200) {
            dialogVisiable.value = false;
          }
          getList();
        })
      }
      
  };

  const handleEdit = function(index, row){
      getById(row.userId).then(res => {
          userForm.value = res.data;
          title.value = "Edit user info"
          dialogVisiable.value = true;
      })
  }

   let create = function(){
    userForm.value = {
      userId:null,
      userName:'',
      nickName:'',
      password:'',
      confirmPassword:''
    };
    title.value = "Insert new user";
    dialogVisiable.value = true;
  };

//   const handleDelete = function(index, row){
//     ElMessageBox.confirm('Are you sure you want to delete this item?', 'Tips', {
//     confirmButtonText: 'Yes',
//     callback: () => {
//         deleteUser(row.userId).then(res => {
//         if(res.status === 200){
//             getList();
//             ElMessage({
//             type: 'info',
//             message: `Success!`,
//           });
//         }
//       });
//     },
//   })
// };

  const handleDelete = function(index, row) {
  ElMessageBox.confirm('Are you sure you want to delete this item?', 'Notice', {
    confirmButtonText: 'Yes',
    cancelButtonText: 'No',
    type: 'warning',
    closeOnClickModal: false, // Disable closing the dialog by clicking on the overlay
    closeOnPressEscape: false, // Disable closing the dialog by pressing the ESC key
  })
  .then(() => {
    // Execute delete operation when the user clicks the "Yes" button
    deleteUser(row.userId).then(res => {
      if (res.status === 200) {
        getList();
        ElMessage({
          type: 'info',
          message: `Success!`,
        });
      }
    });
  })
  .catch(() => {
    // Do nothing when the user clicks the "No" button or closes the dialog
    ElMessage({
      type: 'info',
      message: 'Deletion cancelled',
    });
  });
};

  
  </script>
<style>

</style>