import Vue from 'vue'
import Router from 'vue-router'
import Hello from '@/components/Hello'
import P1MainLyra from '@/components/P1MainLyra'
import P2MainVue from '@/components/P2MainVue'
import P3Columns from '@/components/P3Columns'
import P4Summary from '@/components/P4Summary'
import P5LyraTypes from '@/components/P5LyraTypes'
import P6ShowcaseTypes from '@/components/P6ShowcaseTypes'
import P7Profiles from '@/components/P7Profiles'
import P8CssRow from '@/components/P8CssRow'


Vue.use(Router)

export default new Router({
    routes: [
        {
            path: '/',
            name: 'hello',
            component: Hello
        },
        {
            path: '/p1mainlyra',
            name: 'P1MainLyra',
            component: P1MainLyra
        },
        {
            path: '/p2mainvue',
            name: 'P2MainVue',
            component: P2MainVue
        },
        {
            path: '/p3columns',
            name: 'P3Columns',
            component: P3Columns
        },
        {
            path: '/p4summary',
            name: 'P4Summary',
            component: P4Summary
        },
        {
            path: '/p5lyratypes',
            name: 'P5LyraTypes',
            component: P5LyraTypes
        },
        {
            path: '/p6showcasetypes',
            name: 'P6ShowcaseTypes',
            component: P6ShowcaseTypes
        },
        {
            path: '/p7profiles',
            name: 'P7Profiles',
            component: P7Profiles
        },
        {
            path: '/p8cssrow',
            name: 'P8CssRow',
            component: P8CssRow
        },
    ]
})
