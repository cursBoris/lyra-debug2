<template>
    <div class="p8cssrow">


        <lyra-grid
                formclass="ru.curs.demo.P8CssRow"
                instanceid="grid6"
                context='{"part1": "part1","part2": "part2","refreshParams": {"selectKey": "","sort": "name,code","filter": ""}}'
        >
        </lyra-grid>


    </div>
</template>

<script>

    export default {

        components: {
            lyraGrid: () => import('lyra-grid/LyraGrid')
        },

        name: 'p8cssrow',

        data() {
            return {}
        },
        methods: {}
    }

</script>


<style>
    .jslivegrid-record-bold {
        overflow: auto;
        background-color: #87cefa;
        font-weight: bold;
    }

    .jslivegrid-record-italic {
        font-style: italic;
    }
</style>
