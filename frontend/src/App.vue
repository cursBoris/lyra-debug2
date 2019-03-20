<template>
    <div id="app">
        <div id="nav">
            <router-link to="/">Лира</router-link>
            |
            <router-link to="/p1mainlyra">Основной лира-функционал</router-link>
            |
            <router-link to="/p2mainvue">Основной vue-функционал</router-link>
            |
            <router-link to="/p3columns">Столбцы</router-link>
            |
            <router-link to="/p4summary">Итоговая строка</router-link>
            |
            <router-link to="/p5lyratypes">'Лира' типы столбцов, Unbound столбцы</router-link>
            |
            <router-link to="/p6showcasetypes">'Showcase' типы столбцов</router-link>
            |
            <router-link to="/p7profiles">Профайлы</router-link>
            |
            <router-link to="/p8cssrow">Стили строки</router-link>
        </div>
        <router-view :hellomsg="msg"></router-view>
    </div>
</template>

<script>

    export default {
        name: 'app',
        data() {
            return {
                msg: 'Welcome to your Lyra Grid'
            }
        }
    }
</script>

<style lang="scss">
    #app {
        font-family: 'Avenir', Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2c3e50;
        margin-top: 10px;
    }

    #nav {
        padding: 10px;

        a {
            font-weight: bold;
            color: #2c3e50;

            &.router-link-exact-active {
                color: #42b983;
            }
        }
    }
</style>
