<template>
  <el-container class="home-container">
    <!-- 头部区域 -->
    <el-header>
      <div>
        <img src="../assets/heima.png" alt />
        <span>ICE Publisher Manage System</span>
      </div>
      <el-button type="info" @click="logout">Exit</el-button>
    </el-header>
    <!-- 页面主题区域 -->
    <el-container>
      <!-- 侧边栏 -->
      <el-aside :width="isCollapse ? '64px' : '200px'">
        <div class="toggle-button" @click="toggleCollapse">|||</div>
        <!-- 侧边栏菜单区域 -->
        <el-menu
          background-color="#333744"
          text-color="#fff"
          active-text-color="#409eff"
          unique-opened
          :collapse="isCollapse"
          :collapse-transition="false"
          :router="true"
          :default-active="activePath"
        >
          <!-- 一级菜单 -->
          <el-submenu :index="item.id+''" v-for="item in menulist" :key="item.id">
            <!-- 一级菜单的模版区域 -->
            <template slot="title">
              <!-- 图标 -->
              <i :class="item.icon"></i>
              <!-- 文本 -->
              <span>{{ item.authName }}</span>
            </template>
            <!-- 二级菜单 -->
            <el-menu-item
              :index="'/'+subItem.path+''"
              v-for="subItem in item.children"
              :key="subItem.id"
              @click="saveNavState('/'+subItem.path)"
            >
              <template slot="title">
                <!-- 图标 -->
                <i class="el-icon-menu"></i>
                <!-- 文本 -->
                <span>{{ subItem.authName }}</span>
              </template>
            </el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>
      <!-- 右侧内容主体 -->
      <el-main>
        <!-- 路由占位符 -->
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  data () {
    return {
      // 左侧菜单数据
      menulist: [
        {
          id: '1',
          authName: 'Use Manage',
          icon: 'el-icon-s-custom',
          children: [
            // { id: 11, authName: '用户列表', path: 'users' },
            { id: 12, authName: 'Person Infor', path: 'infor' }]
        },
        // {
        //   id: '2',
        //   authName: '权限管理',
        //   icon: 'el-icon-s-goods',
        //   children: [
        //     { id: 21, authName: '角色列表', path: 'roles' },
        //     { id: 22, authName: '权限列表', path: 'rights' }
        //   ]
        // },
        {
          id: '3',
          authName: 'Game Manage',
          icon: 'el-icon-s-goods',
          children: [
            { id: 31, authName: 'Game List', path: 'goods' },
            { id: 32, authName: 'Add Game', path: 'add' }
            // { id: 33, authName: '标签管理', path: 'tags' }
          ]
        },
        {
          id: '4',
          authName: 'Order Manage',
          icon: 'el-icon-s-order',
          children: [{ id: 31, authName: 'Order List', path: 'orders' }]
        }
        // {
        //   id: '5',
        //   authName: '数据统计',
        //   icon: 'el-icon-s-marketing',
        //   children: [{ id: 41, authName: '数据报表', path: 'diagrams' }]
        // }
      ],
      // 是否折叠
      isCollapse: false,
      // 被激活的链接地址
      activePath: ''
    }
  },
  created () {
    this.activePath = window.sessionStorage.getItem('activePath')
  },
  methods: {
    logout () {
      this.$router.push('/login')
      this.$message.info('User Exit')
    },
    // 点击按钮，切换菜单的折叠与展开
    toggleCollapse () {
      this.isCollapse = !this.isCollapse
    },
    // 保存链接的激活状态
    saveNavState (activePath) {
      window.sessionStorage.setItem('activePath', activePath)
      this.activePath = activePath
    }
  }
}
</script>

<style lang="less" scoped>
.home-container {
  height: 100%;
}

.el-header {
  background-color: #373d41;
  display: flex;
  justify-content: space-between;
  padding-left: 0;
  align-items: center;
  color: #fff;
  font-size: 20px;
  > div {
    display: flex;
    align-items: center;
    span {
      margin-left: 15px;
    }
  }
}

.el-aside {
  background-color: #333744;
  .el-menu {
    border-right: none;
  }
}

.el-main {
  background-color: #eaedf1;
}

.toggle-button {
  background-color: #4a5064;
  font-size: 10px;
  line-height: 24px;
  color: #fff;
  text-align: center;
  letter-spacing: 0.2em;
  cursor: pointer;
}
</style>
