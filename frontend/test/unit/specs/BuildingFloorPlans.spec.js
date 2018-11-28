import Vue from 'vue'
import BuildingFloorPlans from '@/components/BuildingFloorPlans'

import Buefy from 'buefy'
import axios from '../__mocks__/axios'

let vm

describe('BuildingFloorPlans.vue', () => {
  beforeEach(() => {
    const Constructor = Vue.extend(BuildingFloorPlans)
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
  it('should call axios.get', () => {
    vm.$nextTick(() => {
      expect(axios.get).toHaveBeenCalled()
    })
  })

  it('should set floor plans', () => {
    vm.$nextTick(() => {
      expect(vm.plans).toEqual(1)
    })
  })

  it('should render floor plan heading', () => {
    vm.$nextTick(() => {
      expect(vm.$el.querySelector('h1').textContent).toContain('Floor Plan')
    })
  })
})
