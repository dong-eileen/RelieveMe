import Vue from 'vue'
import BuildingList from '@/components/BuildingList'
import Buefy from 'buefy'
import axios from '../__mocks__/axios'

Vue.use(Buefy, {
  defaultIconPack: 'fas',
  defaultContainerElement: '#content'
  // ...
})
let vm

describe('BuildingList.vue', () => {
  beforeEach(() => {
    const Constructor = Vue.extend(BuildingList)
    vm = new Constructor().$mount()
  })
  it('should render correct header', () => {
    expect(vm.$el.querySelector('h1').textContent).toEqual('All Buildings')
  })

  it('should call axios.get with correct route', () => {
    expect(axios.get).toHaveBeenCalledWith(
      `/api/buildings?sort=None&filter=None&region=None`
    )
  })

  it('should render data', () => {
    vm.$nextTick(() => {
      expect(vm.buildings).toEqual([1])
    })
  })

  it('should stop loading', () => {
    vm.$nextTick(() => {
      expect(vm.loading).toBeFalsy()
    })
  })
})
