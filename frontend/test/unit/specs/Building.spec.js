import Vue from 'vue'
import Building from '@/components/Building'
import { shallowMount, createLocalVue } from '@vue/test-utils'
import VueRouter from 'vue-router'
import Buefy from 'buefy'

let vm

describe('Building.vue', () => {
  beforeEach(() => {
    const Constructor = Vue.extend(Building)
    vm = new Constructor().$mount()

    // const localVue = createLocalVue()
    // localVue.use(VueRouter)
    Vue.use(Buefy, {
      defaultIconPack: 'fas',
      defaultContainerElement: '#content'
      // ...
    })
    /* const router = new VueRouter()

    shallowMount(vm, {
      localVue,
      router
    }) */
  })
  it('should render correct header', () => {
    vm.$nextTick(() => {
      expect(vm.$el.querySelector('h1').textContent).toEqual('All Buildings')
    })
  })
})
