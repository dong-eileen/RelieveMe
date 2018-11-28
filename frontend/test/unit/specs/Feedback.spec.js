import Vue from 'vue'
import Feedback from '@/components/Feedback'
import Buefy from 'buefy'
import axios from '../__mocks__/axios'

Vue.use(Buefy, {
  defaultIconPack: 'fas',
  defaultContainerElement: '#content'
  // ...
})
let vm

describe('Feedback.vue', () => {
  beforeEach(() => {
    const Constructor = Vue.extend(Feedback)
    vm = new Constructor().$mount()
  })
  it('should render correct header', () => {
    expect(vm.$el.querySelector('h1').textContent).toEqual('Send an email')
  })

  describe.each([
    'feedback-form',
    'email',
    'category',
    'subject',
    'description'
  ])('%s field', field => {
    test('renders', () => {
      expect(vm.$el.querySelector(`#${field}`)).toBeDefined()
    })
  })

  it('should set correct categories', () => {
    expect(vm.categories).toEqual([
      { id: 0, text: 'Feedback' },
      { id: 1, text: 'Maintenance issue' },
      { id: 2, text: 'Report inaccurate data' },
      { id: 3, text: 'Other' }
    ])
  })

  describe('when form submitted', () => {
    beforeEach(() => {
      vm.submit()
    })
    it('should call axios.post', () => {
      expect(axios.post).toHaveBeenCalled()
    })
  })
})
