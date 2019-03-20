<template>
    <div class="p7profiles">


        <lyra-grid
                formclass="ru.curs.demo.P7Profiles"
                instanceid="grid7"
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

        name: 'p7profiles',

        data() {
            return {}
        },
        methods: {}
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
