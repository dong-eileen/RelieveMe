import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import BuildingList from '@/components/BuildingList'
import Building from '@/components/Building'
import BuildingFloorPlans from '@/components/BuildingFloorPlans'
import Feedback from '@/components/Feedback'
import FeedbackSubmitted from '@/components/FeedbackSubmitted'
import IssueForm from '@/components/IssueForm'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/buildings/',
      name: 'BuildingList',
      component: BuildingList
    },
    {
      path: '/buildings/:name',
      name: 'Building',
      component: Building
    },
    {
      path: '/buildings/:name/floorplans',
      name: 'BuildingFloorPlans',
      component: BuildingFloorPlans
    },
    {
      path: '/feedback',
      name: 'Feedback',
      component: Feedback,
      props: (route) => ({ preSelectedCategory: route.query.category })
    },
    {
      path: '/issueForm',
      name: 'IssueForm',
      component: IssueForm,
      props: true
    },
    {
      path: '/feedbackSubmitted',
      name: 'FeedbackSubmitted',
      component: FeedbackSubmitted
    }
  ]
})
