import Vue from 'vue'
import App from './App.vue'
import router from './router'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.config.productionTip = false

Vue.use(BootstrapVue)

new Vue({
    router,
    render: h => h(App)
}).$mount('#app')


function getLyraConfig() {
    return {
        baseUrlMetadata: "http://localhost:8081",
        baseUrlData: "http://localhost:8081",
        baseUrlScrollback: "http://localhost:8088",
    };
}

window.getLyraConfig = getLyraConfig;



