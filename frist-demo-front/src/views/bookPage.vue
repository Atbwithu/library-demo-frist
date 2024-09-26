<style>
.box {
    width: 100%;
    display: flex;
    flex-direction: row;
    height: 800px;
}

.bookInfo {
    /* flex: 1; */
    width: 100px;
    height: 200px;
}

.content {
    flex: 3;
    overflow-y: scroll;
    /* height: 1800px; */
}

.bookList {
    display: flex;
    list-style-type: none;
    flex-direction: row;
    flex-wrap: wrap;
    /* overflow:auto; */
    /* height: 800px; */
    /* overflow: hidden; */
    
}

.bookList li {
    display: flex;
    flex-basis: 200px;
    margin-top: 40px;
    width: 100%;
    margin-left: 50px;
}
.bookList el-image {

    flex: 1;
}
.bookList #intro {
    display: flex;
    flex: 1;
    flex-direction: column;
    
}
</style>
<template>
    <div class="box">
        <div class="guide" style="flex: 1;">
            <el-card style="height: 800px;">
                <div slot="header">
                    书籍分类
                </div>
                <div>
                    <ul>
                        <li v-for="item in categories" :key="item.id">
                            {{ item.name }}
                        </li>
                    </ul>
                </div>
            </el-card>
        </div>
        <div class="content">
            <el-card>
                    <ul class="bookList" >
                        <li v-for=" item in allBook " :key="item.id">
                                <el-image  :key="url" :src="item.cover" lazy></el-image>
                                <div id="intro">
                                    <div> <b>书名：<br></b>{{ item.name }}</div>
                                    <div style="font-size: 15px;">
                                        <b>简介：<br></b>{{ item.introduction }}
                                    </div>
                                    <div style="font-size: 10px;">
                                        <b>上架时间：</b>{{ item.createTime }}
                                    </div>
                                </div>
                        </li>
                    </ul>
            </el-card>
        </div>
        <div class="other" style="flex: 1;">
            <el-card style="height: 800px;">

            </el-card>
        </div>
    </div>
</template>
<script>
import axios from 'axios';

export default {
    data() {
        return {
            categories: [],
            allBook: []
        }
    },
    methods: {
        getAllBook() {
            axios({
                url: "http://localhost:8082/book/getAllBook ",
                method: "get"
            }).then((resp) => {
                this.allBook = resp.data["data"]
            })
        }
    },
    created() {
        this.getAllBook()
        console.log(this.$store.state.user);
        
    }
}
</script>
