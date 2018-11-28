import Vue from 'vue'
import TopMenu from '@/components/TopMenu'
import Buefy from 'buefy'

let vm
describe('TopMenu.vue', () => {
  beforeEach(() => {
    const Constructor = Vue.extend(TopMenu)
    vm = new Constructor().$mount()

    // const localVue = createLocalVue()
    // localVue.use(VueRouter)
    Vue.use(Buefy, {
      defaultIconPack: 'fas',
      defaultContainerElement: '#content'
      // ...
    })
  })
  it('should render Home', () => {
    vm.$nextTick(() => {
      expect(vm.$el.querySelector('.router-link')).toContain('Home')
    })
  })
})
