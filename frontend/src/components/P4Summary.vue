<template>
    <div class="p4summary">


        <lyra-grid
                formclass="ru.curs.demo.P4Summary"
                instanceid="grid10"
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

        name: 'p4summary',

        data() {
            return {}
        },
        methods: {}
    }

</script>


<style>
    .summary-row {
        font-weight: bold;

        color: silver;
        background-color: blue;
    }
</style>
