<template>
    <div class="p1mainlyra">


        <b-form-textarea style="width:1150px;height:50px;"
                         id="context" v-model="context2" :rows="3" :max-rows="3">
        </b-form-textarea>


        <b-button-toolbar>
            <b-button-group>
                <b-button v-on:click="refresh442">ALL Refresh grid</b-button>
            </b-button-group>
        </b-button-toolbar>


        <lyra-grid
                formclass="ru.curs.demo.P1MainLyra"
                instanceid="grid1"

                context='{"part1": "part1","part2": "part2","refreshParams": {"selectKey": "","sort": "name,code","filter": "filter conditions"}}'
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

        name: 'P1MainLyra',

        data() {
            return {
                context2:
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
            refresh442: function () {
                lyraGridEvents.$emit('refresh', 'ru.curs.demo.P1MainLyra', 'grid1', this.context2);
                //event => this.$emit('refresh', 'ru.curs.demo.P1MainLyra', 'grid1', this.context2)
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
