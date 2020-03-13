import Vue from 'vue'
import App from './App.vue'
import router from './router'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

//import {Lyra} from 'lyra-grid'
//Vue.use(Lyra)

Vue.config.productionTip = false

Vue.use(BootstrapVue)


new Vue({
    router,
    render: h => h(App)
}).$mount('#app')


function getLyraConfig() {
    return {
        //baseUrl: "http://localhost:8081",
        //baseUrlScrollback: "http://localhost:8088",


        showMessageFunction(vueComponent, message) {
            vueComponent.$bvModal.msgBoxOk(message, {
                title: 'Error',
                headerClass: 'p-2 border-bottom-0',
                footerClass: 'p-2 border-top-0',
                centered: true,
            });
        }


    };
}

window.getLyraConfig = getLyraConfig;



