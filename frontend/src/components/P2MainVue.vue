<template>
  <div class="p2mainvue">


    <b-form-group
            label="Events" label-for="textarea">

      <b-form-textarea style="width:1150px;height:200px;"
                       id="textarea" v-model="message" :rows="20" :max-rows="20">
      </b-form-textarea>

      <p></p>

      <b-form-textarea style="width:1150px;height:50px;"
                       id="context" v-model="context" :rows="3" :max-rows="3">
      </b-form-textarea>


      <b-button-toolbar>
        <b-button-group>
          <b-button v-on:click="clear">Clear events</b-button>
        </b-button-group>
        <p></p>
        <b-button-group>
          <b-button v-on:click="refresh1">Refresh grid1</b-button>
          <b-button v-on:click="refresh2">Refresh grid2</b-button>
          <b-button v-on:click="refresh3">Refresh grid3</b-button>
          <b-button v-on:click="refresh44">ALL Refresh grid1</b-button>
        </b-button-group>
        <p></p>
      </b-button-toolbar>


    </b-form-group>

    <p></p>

    <!--
        context  = '{"part1": "part1","part2": "part2","refreshParams": {"selectKey": "","sort": "name desc,code desc","filter": "filter conditions"}}'
        context  = '{"part1": "part1","part2": "part2"}'
    -->


    <lyra-grid
            formclass="ru.curs.demo.P2MainVue"
            instanceid="grid1"

            context='{"part1": "part1","part2": "part2","refreshParams": {"selectKey": "","sort": "gninmb,code","filter": ""}}'

            v-on:select="select1"
            v-on:dblclick="dblclicked1"
            v-on:click="clicked1"

    >
    </lyra-grid>

    <p></p>

    <lyra-grid
            formclass="ru.curs.demo.P2MainVue"
            instanceid="grid2"

            context='{"part1": "part1","part2": "part2","refreshParams": {"selectKey": "","sort": "code","filter": "filter conditions"}}'

            v-on:select="select2"
            v-on:dblclick="dblclicked2"
            v-on:click="clicked2"

    >
    </lyra-grid>

    <p></p>


    <lyra-grid
            formclass="ru.curs.demo.P2MainVue"
            instanceid="grid3"

            context='{"part1": "part1","part2": "part2","refreshParams": {"selectKey": "","sort": "name,code","filter": "filter conditions"}}'

            v-on:select="select3"
            v-on:dblclick="dblclicked3"
            v-on:click="clicked3"

    >
    </lyra-grid>


  </div>
</template>

<script>

import {lyraGridEvents} from 'lyra-grid/LyraGrid'

export default {

    components: {
        lyraGrid: () => import('lyra-grid/LyraGrid')
    },

    name: 'P2MainVue',

    data() {
        return {
            message: '',
            context:
                '{' +
                '"part1": "part1",' +
                '"part2": "part2",' +

                '"refreshParams": {' +
                //74000004000079300
                //current
                '"selectKey": ["74000004000079300"],' +
                '"sort": "name,code",' +
                //'"sort": "ocatd",'+
                '"filter": "filter conditions"' +
                '}' +
                '}',

        }
    },
    methods: {
        refresh1: function () {
            lyraGridEvents.$emit(
                'refresh',
                'ru.curs.demo.P2MainVue',
                'grid1',
                '{' +
                '	"part1": "part1",' +
                '	"part2": "part2",' +

                '	"refreshParams": {' +
                //74000004000079300
                '		"selectKey": "",' +
                '		"sort": "name,code",' +
                //'		"sort": "ocatd",' +
                '		"filter": ""' +
                '	}' +
                '}'
            );
        },
        refresh2: function () {
            lyraGridEvents.$emit(
                'refresh',
                'ru.curs.demo.P2MainVue',
                'grid2',
                '{' +
                '	"part1": "part1",' +
                '	"part2": "part2",' +

                '	"refreshParams": {' +
                //74000004000079300
                '		"selectKey": "",' +
                //'		"sort": "name,code",'+
                '		"sort": "gninmb",' +
                '		"filter": "filter conditions"' +
                '	}' +
                '}'
            );
        },
        refresh3: function () {
            lyraGridEvents.$emit(
                'refresh',
                'ru.curs.demo.P2MainVue',
                'grid3',
                '{' +
                '	"part1": "part1",' +
                '	"part2": "part2",' +

                '	"refreshParams": {' +
                //74000004000079300
                '		"selectKey": "",' +
                '		"sort": "name,code",' +
                //'		"sort": "ocatd",'+
                '		"filter": "filter conditions"' +
                '	}' +
                '}'
            );
        },

        refresh44: function () {
            lyraGridEvents.$emit('refresh', 'ru.curs.demo.P2MainVue', 'grid1', this.context);
        },


        clear: function () {
            this.message = '';
        },

        select1: function (formClass, instanceId, obj) {
            console.log("select1");
            this.message = this.message + '\n' + "event:select1" + '\n' + "formClass=" + formClass + ", instanceId=" + instanceId + '\n' + JSON.stringify(obj);
        },
        select2: function (formClass, instanceId, obj) {
            console.log("select2");
            this.message = this.message + '\n' + "event:select2" + '\n' + "formClass=" + formClass + ", instanceId=" + instanceId + '\n' + JSON.stringify(obj);
        },
        select3: function (formClass, instanceId, obj) {
            console.log("select3");
            this.message = this.message + '\n' + "event:select3" + '\n' + "formClass=" + formClass + ", instanceId=" + instanceId + '\n' + JSON.stringify(obj);
        },

        clicked1: function (formClass, instanceId, obj) {
            this.message = this.message + '\n' + "event:clicked1" + '\n' + "formClass=" + formClass + ", instanceId=" + instanceId + '\n' + JSON.stringify(obj);
        },
        clicked2: function (formClass, instanceId, obj) {
            this.message = this.message + '\n' + "event:clicked2" + '\n' + "formClass=" + formClass + ", instanceId=" + instanceId + '\n' + JSON.stringify(obj);
        },
        clicked3: function (formClass, instanceId, obj) {
            this.message = this.message + '\n' + "event:clicked3" + '\n' + "formClass=" + formClass + ", instanceId=" + instanceId + '\n' + JSON.stringify(obj);
        },

        dblclicked1: function (formClass, instanceId, obj) {
            this.message = this.message + '\n' + "event:dblclicked1" + '\n' + "formClass=" + formClass + ", instanceId=" + instanceId + '\n' + JSON.stringify(obj);
        },
        dblclicked2: function (formClass, instanceId, obj) {
            this.message = this.message + '\n' + "event:dblclicked2" + '\n' + "formClass=" + formClass + ", instanceId=" + instanceId + '\n' + JSON.stringify(obj);
        },
        dblclicked3: function (formClass, instanceId, obj) {
            this.message = this.message + '\n' + "event:dblclicked3" + '\n' + "formClass=" + formClass + ", instanceId=" + instanceId + '\n' + JSON.stringify(obj);
        },

    }
}

</script>

