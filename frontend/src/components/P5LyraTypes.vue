<template>
    <div class="p5lyratypes">


        <lyra-grid
                formclass="ru.curs.demo.P5LyraTypes"
                instanceid="grid1"

                context='{"part1": "part1","part2": "part2","refreshParams": {"selectKey": "","sort": "name,code","filter": "filter conditions"}}'
        >
        </lyra-grid>


    </div>
</template>

<script>


    export default {


        components: {
            lyraGrid: () => import('lyra-grid/LyraGrid')
        },


        name: 'P5LyraTypes',


        data() {
            return {}
        },
        methods: {}

    }

</script>

