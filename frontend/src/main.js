import Vue from 'vue'
import App from './App.vue'
import router from './router'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

import {Lyra} from 'lyra-grid'


Vue.config.productionTip = false

Vue.use(BootstrapVue)

Vue.use(Lyra)

new Vue({
    router,
    render: h => h(App)
}).$mount('#app')


function getLyraConfig() {
    return {
        //baseUrl: "http://localhost:8081",
        //baseUrlScrollback: "http://localhost:8088",
    };
}

window.getLyraConfig = getLyraConfig;



