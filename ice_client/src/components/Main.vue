<template>
<div style="overflow: auto; height: 100%" id="main">
<!--  <div>-->
  <el-header height="120px">
    <el-row >
      <el-col :span="1"><div class="grid-content"></div></el-col>
      <el-col :span="6"><div class="grid-content">
        <img src="../assets/header/home_logo.jpg" width="374" height="120" class="img-logo" @click="enterMainIndex()" alt/>
      </div>
      </el-col>
      <el-col :span="15"><div class="grid-content bg-purple">
      </div></el-col>
      <el-col :span="2"><div class="logout-button">
        <el-button type="info" @click="logout">Exit</el-button>
      </div></el-col>
    </el-row>
  </el-header>
  <el-menu
    id="main-menu-id"
    :default-active="activeIndex2"
    :class="headerFixed?'isFixed':''"
    mode="horizontal"
    @select="handleSelect"
    background-color="#545c64"
    text-color="#fff"
    active-text-color="#409EFE">
    <!-- 一级菜单 -->
    <el-submenu :index="item.id" v-for="(item, i) in menuList" :key="i">
      <!-- 一级菜单 -->
      <template slot="title">
        <span>{{ item.authName }}</span>
      </template>
      <!-- 二级菜单 -->
      <el-menu-item
        :index="subItem.menuId"
        v-for="(subItem, i) in item.children"
        :key="i"
      >
        <template slot="title">
          <span>{{ subItem.authName }}</span>
        </template>
      </el-menu-item>
    </el-submenu>
    <el-menu-item class="search-menu" index="4" >
    <el-input class="search-input" v-model="queryInfo" placeholder="Input Here">
      <el-button  @click="search" class="search-button" slot="append" icon="el-icon-search"></el-button>
    </el-input>
    </el-menu-item>
    <el-menu-item index="5" >My Page</el-menu-item>
    <el-menu-item index="6">My Orders</el-menu-item>
    <el-menu-item index="7">Cart</el-menu-item>
  </el-menu>
    <el-row  :class="[{'after-menu':!headerFixed}, {'full-menu':headerFixed}]"></el-row>
  <!-- 内容主体 -->
  <el-main>
    <!-- 路由占位符 -->
    <router-view></router-view>
  </el-main>
  </div>
</template>

<script>
export default {
  name: 'Main',
  data () {
    return {
      activeIndex: '1',
      activeIndex2: '1',
      offsetTop: 0,
      offsetHeight: 0,
      headerFixed: false,
      // isMainIndex: true,
      menuList: [
        {
          id: '1',
          authName: 'Category',
          // TODO 获取分类列表
          children: [
            { menuId: '1-1', authName: 'Action', path: 'action' },
            { menuId: '1-2', authName: 'Adventure', path: 'adventure' },
            { menuId: '1-3', authName: 'Arcade', path: 'arcade' },
            { menuId: '1-4', authName: 'Board Games', path: 'boardgames' },
            { menuId: '1-5', authName: 'Racing', path: 'racing' },
            { menuId: '1-6', authName: 'Role-Playing Games', path: 'roleplayinggames' },
            { menuId: '1-7', authName: 'Shooter', path: 'shooter' },
            { menuId: '1-8', authName: 'Simulation', path: 'simulation' },
            { menuId: '1-9', authName: 'Sports', path: 'sports' },
            { menuId: '1-10', authName: 'Strategy', path: 'strategy' }
          ]
        },
        {
          id: '2',
          authName: 'Console',
          // TODO 获取平台列表
          children: [
            { menuId: '2-1', authName: 'PS3', path: '/PlatForm/ps3' },
            { menuId: '2-2', authName: 'PS4', path: '/PlatForm/ps4' },
            { menuId: '2-3', authName: 'PS Vita', path: '/PlatForm/psvita' },
            { menuId: '2-4', authName: 'PSP', path: '/PlatForm/' },
            { menuId: '2-5', authName: 'Nintendo Switch', path: '/PlatForm/nintendoswitch' },
            { menuId: '2-6', authName: 'Nintendo 3DS', path: '/PlatForm/nintendo3ds' },
            { menuId: '2-7', authName: 'xbox 360', path: '/PlatForm/xbox360' },
            { menuId: '2-8', authName: 'xbox one', path: '/PlatForm/xboxone' }
          ]
        },
        {
          id: '3',
          authName: 'Publisher',
          // TODO 获取发行商列表
          children: [
            // { menuId: '3-1', authName: '发行商1', path: '' },
            // { menuId: '3-2', authName: '发行商2', path: '' },
            // { menuId: '3-3', authName: '发行商3', path: '' }
          ]
        }
      ],
      queryInfo: ''
    }
  },
  methods: {
    handleSelect (key, keyPath) {
      // console.log('点击菜单栏key', key)
      // console.log('点击菜单栏keyPath', keyPath)
      switch (key) {
        case '5':
          console.log('进入一个页面', 55555555)
          this.$router.push('/PersonPage')
          break
        case '6':
          console.log('进入一个页面', 66666666)
          this.$router.push('/PersonOrder')
          break
        case '7':
          console.log('进入一个页面', 77777777)
          this.$router.push('/ShoppingCart')
          break
        case '1-1':
          console.log('进入一个页面', '1-1')
          this.$router.push('/Category/Action')
          break
        case '1-2':
          console.log('进入一个页面', '1-2')
          this.$router.push('/Category/Adventure')
          break
        case '1-3':
          console.log('进入一个页面', '1-3')
          this.$router.push('/Category/Arcade')
          break
        case '1-4':
          console.log('进入一个页面', '1-4')
          this.$router.push('/Category/Board Games')
          break
        case '1-5':
          console.log('进入一个页面', '1-5')
          this.$router.push('/Category/Racing')
          break
        case '1-6':
          console.log('进入一个页面', '1-6')
          this.$router.push('/Category/Role-Playing Games')
          break
        case '1-7':
          console.log('进入一个页面', '1-7')
          this.$router.push('/Category/Shooter')
          break
        case '1-8':
          console.log('进入一个页面', '1-8')
          this.$router.push('/Category/Simulation')
          break
        case '1-9':
          console.log('进入一个页面', '1-9')
          this.$router.push('/Category/Sports')
          break
        case '1-10':
          console.log('进入一个页面', '1-10')
          this.$router.push('/Category/Strategy')
          break
        case '2-1':
          console.log('进入一个页面', '2-1')
          this.$router.push('/PlatForm/PS3')
          break
        case '2-2':
          console.log('进入一个页面', '2-2')
          this.$router.push('/PlatForm/PS4')
          break
        case '2-3':
          console.log('进入一个页面', '2-3')
          this.$router.push('/PlatForm/PS Vita')
          break
        case '2-4':
          console.log('进入一个页面', '2-4')
          this.$router.push('/PlatForm/PSP')
          break
        case '2-5':
          console.log('进入一个页面', '2-5')
          this.$router.push('/PlatForm/Nintendo Switch')
          break
        case '2-6':
          console.log('进入一个页面', '2-6')
          this.$router.push('/PlatForm/Nintendo 3DS')
          break
        case '2-7':
          console.log('进入一个页面', '2-7')
          this.$router.push('/PlatForm/xbox 360')
          break
        case '2-8':
          console.log('进入一个页面', '2-8')
          this.$router.push('/PlatForm/xbox one')
          break
        case '3-1':
          console.log('进入一个页面', '3-1')
          this.$router.push('/PublisherPage/' + this.menuList[2].children[0].id)
          break
        case '3-2':
          console.log('进入一个页面', '3-2')
          this.$router.push('/PublisherPage/' + this.menuList[2].children[1].id)
          break
        case '3-3':
          console.log('进入一个页面', '3-3')
          this.$router.push('/PublisherPage/' + this.menuList[2].children[2].id)
          break
        case '3-4':
          console.log('进入一个页面', '3-4')
          this.$router.push('/PublisherPage/' + this.menuList[2].children[3].id)
          break
        case '3-5':
          console.log('进入一个页面', '3-5')
          this.$router.push('/PublisherPage/' + this.menuList[2].children[4].id)
          break
        case '3-6':
          console.log('进入一个页面', '3-6')
          this.$router.push('/PublisherPage/' + this.menuList[2].children[5].id)
          break
        case '3-7':
          console.log('进入一个页面', '3-7')
          this.$router.push('/PublisherPage/' + this.menuList[2].children[6].id)
          break
        case '3-8':
          console.log('进入一个页面', '3-8')
          this.$router.push('/PublisherPage/' + this.menuList[2].children[7].id)
          break
      }
    },
    handleScroll () {
      // 兼容性，获取页面滚动距离
      var scrollTop = window.pageYOffset || document.getElementById('main').scrollTop || document.body.scrollTop
      // 判断页面滚动的距离是否大于吸顶元素的位置
      this.headerFixed = scrollTop > this.offsetTop
    },
    search () {
      console.log('search:', this.queryInfo)
      if (this.queryInfo === '') {
        this.$router.push('/MainIndex')
        return
      }
      this.$router.push('/SearchGame/' + this.queryInfo)
    },
    getPublisherList () {
      this.$axios.get('/api/getPublishers')
        .then(response => {
          // console.log('getPublisherList response', response)
          if (response.data.status === '200') {
            for (let index in response.data.result) {
              if (index >= 8) {
                break
              }
              let menuId = '3-' + (parseInt(index) + 1).toString()
              let publisher = {
                menuId: menuId,
                authName: response.data.result[index].publisherName,
                id: response.data.result[index].publisherId
              }
              this.menuList[2].children.push(publisher)
            }
          } else {
            this.$message.info('Publisher list loading failed, retrying')
          }
        }).catch(() => {
          this.$message.info('Publisher list loading failed, retrying')
        })
    },
    logout () {
      this.$router.push('/login')
      this.$message.info('User exit')
    },
    enterMainIndex () {
      this.$router.push('/MainIndex')
    }
  },
  mounted () {
    // 对整个页面滚轮进行监听，每发生一次滚轮事件，执行一次方法
    // window.addEventListener('scroll', this.handleScroll)
    document.getElementById('main').addEventListener('scroll', this.handleScroll)
    // DOM异步更新 对未来更新后的视图进行操作 在更新后执行
    // 监听dom渲染完成
    this.$nextTick(function () {
      let mainMenu = document.getElementById('main-menu-id')
      // 这里要得到top的距离
      this.offsetTop = mainMenu.offsetTop
    })
  },
  // 每次更新组件，检查路由变化
  created () {
    // console.log(this.isMainIndex)
    // if (this.$route.path.indexOf('MainIndex') === -1) {
    //   this.isMainIndex = false
    // } else {
    //   this.isMainIndex = true
    // }
    this.getPublisherList()
  },
  destroyed () {
    // 移除监听
    document.getElementById('main').removeEventListener('scroll', this.handleScroll)
  }
  // watch: {
  //   $route (newRouter, oldRouter) {
  //     // console.log(this.$route.path)
  //     // console.log(newRouter.path)
  //     // console.log(newRouter.path.indexOf('MainIndex'))
  //     if (newRouter.path.indexOf('MainIndex') === -1) {
  //       this.isMainIndex = false
  //       console.log(this.isMainIndex)
  //     } else {
  //       this.isMainIndex = true
  //     }
  //   }
  // }
}
</script>

<style scoped>
  .isFixed{
    position: fixed;
    top: 0px;
    width: 100%;
    z-index: 10;
  }
  .after-menu{
    display: none;
  }
.full-menu{
  height: 61px;
}
  .el-header{
    background-image: url("../assets/header/home_head_bg.png");
  }
  .grid-content {
    height: 120px;
  }
  .infiniteScroll{
    display: none;
  }
  .search-menu{
    border-bottom: 0 !important;
  }
  .search-menu:hover{
    background-color: #545c64 !important;
    border-bottom: 0 !important;
  }
  .search-input{
    height: 40px !important;
  }
  .search-button{
    height: 45px;
  }
  .logout-button{
    margin-top: 40px;
  }
  .img-logo{
    cursor:pointer;
  }
</style>
