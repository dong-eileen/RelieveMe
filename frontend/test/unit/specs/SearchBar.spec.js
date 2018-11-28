import Vue from 'vue'
import SearchBar from '@/components/SearchBar'
import Buefy from 'buefy'
import axios from '../__mocks__/axios'

let vm

describe('SearchBar.vue', () => {
  beforeEach(() => {
    const Constructor = Vue.extend(SearchBar)
    Vue.use(Buefy, {
      defaultIconPack: 'fas',
      defaultContainerElement: '#content'
      // ...
    })
    vm = new Constructor().$mount()

    // const localVue = createLocalVue()
    // localVue.use(VueRouter)
  })
  it('should render search bar', () => {
    vm.$nextTick(() => {
      expect(vm.$el.querySelector('#search-bar').placeholder).toEqual(
        'Search for a building'
      )
    })
  })

  it('should call axios.get', () => {
    expect(axios.get).toHaveBeenCalled()
  })

  it('should render buildings', () => {
    expect(vm.buildings).toEqual(['hi', 'bob', 'bill'])
  })
})
