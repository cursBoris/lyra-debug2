<template>
    <div class="p3columns">


        <b-form-group
                label="Events" label-for="textarea">

            <b-form-textarea style="width:1150px;height:300px;"
                             id="textarea" v-model="message2" :rows="20" :max-rows="20">
            </b-form-textarea>

            <p></p>

            <b-button-toolbar>
                <b-button-group>
                    <b-button v-on:click="clear2">Clear events</b-button>
                </b-button-group>
                <p></p>
                <p></p>
                <b-button-group>
                    <b-button v-on:click="hideColumns">hideColumns code, socr</b-button>
                    <b-button v-on:click="showColumns">showColumns code, socr</b-button>
                </b-button-group>
                <p></p>
            </b-button-toolbar>

        </b-form-group>

        <lyra-grid
                formclass="ru.curs.demo.P3Columns"
                instanceid="grid9"

                context='{"part1": "part1","part2": "part2","refreshParams": {"selectKey": "","sort": "name,code","filter": ""}}'

                v-on:columns-info="columnsInfo"

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

        name: 'p3columns',

        data() {
            return {
                message2: '',
            }
        },
        methods: {
            hideColumns: function () {
                var arr = [{id: "code", visible: false}, {id: "socr", visible: false}];
                lyraGridEvents.$emit('set-columns-visibility', 'ru.curs.demo.P3Columns', 'grid9', arr);
            },
            showColumns: function () {
                var arr = [{id: "code", visible: true}, {id: "socr", visible: true}];
                lyraGridEvents.$emit('set-columns-visibility', 'ru.curs.demo.P3Columns', 'grid9', arr);
            },

            columnsInfo: function (formClass, instanceId, obj) {
                this.message2 = this.message2 + '\n' + "event:columns-info" + '\n' + "formClass=" + formClass + ", instanceId=" + instanceId + '\n' + JSON.stringify(obj);
            },
            clear2: function () {
                this.message2 = '';
            },
        }
    }

</script>


<style scoped>
    h1, h2 {
        font-weight: normal;
    }

    ul {
        list-style-type: none;
        padding: 0;
    }

    li {
        display: inline-block;
        margin: 0 10px;
    }

    a {
        color: #42b983;
    }
</style>
