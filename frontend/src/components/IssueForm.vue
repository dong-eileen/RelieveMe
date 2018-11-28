<template>
<div id="issue-form" >
  <h1 class="title is-2">Send an email</h1>
  <form id="issue" align="left">
    <b-field horizontal label ="Email" :type="errors.has('email') ? 'is-danger' : email === null ? '' : 'is-success'">
      <b-input type="text" id="email" name="email" v-model="email" v-validate="'required|email'"></b-input>
    </b-field>

    <b-field horizontal label ="Category">
      <b-select id="category" v-model="selectedCategory" @input="categorySelect()">
        <option
          v-for="category in categories"
          :key="category"
          :value="category">
          {{category}}
        </option>
      </b-select>
    </b-field>

    <b-field v-if="templateSelectToggle" horizontal label ="Common Issues">
      <b-select id="issue-template" v-model="selectedTemplate" @input="templateSelect()">
        <option
          v-for="template in templates"
          :key="template"
          :value="template">
          {{template}}
        </option>
      </b-select>
    </b-field>

    <b-field horizontal label="Bathroom ID">
      <b-input type="text" id="bathroomId" v-model="bathroomId" disabled></b-input>
    </b-field>

    <b-field horizontal label="Subject"
             :type="errors.has('subject') ? 'is-danger' : subject === null ? '' : 'is-success'">
      <b-input name="subject" type="text" v-validate="'required|min:1'" id="subject" v-model="subject"></b-input>
    </b-field>

    <b-field horizontal
             label ="Description"
             :type="errors.has('description') ? 'is-danger' : description === null ? '' : 'is-success'">
      <b-input type="textarea"
               id="description"
               rows="10"
               cols ="70"
               v-model="description"
               v-validate="'required|min:1'"
               name="description"></b-input>
    </b-field>

  <b-field horizontal>
        <vue-recaptcha
            ref="recaptcha"
            @verify="onCaptchaVerified"
            @expired="resetCaptcha"
            size="checkbox"
            sitekey="6Lf4fH0UAAAAAGD0za3-huxlTd-sp2Ieg8PP4-Ti">
        </vue-recaptcha>
    </b-field>
    <p class="has-text-danger" v-if="captchaError">Please complete the CAPTCHA.</p>
    <p class="has-text-danger" v-if="serverError">A server error occurred. Please try again later.</p>
    <p class="has-text-danger" v-if="validationErrorPopup">Please complete all fields.</p>

    <b-field horizontal>
      <p class="control">
        <button class="button is-primary" @click.stop.prevent="validateBeforeSubmit()">Submit</button>
        <b-loading :is-full-page="true" :active.sync="isLoading" :can-cancel="false"></b-loading>
      </p>
    </b-field>
  </form>
</div>
</template>

<script>
import axios from 'axios'
import VueRecaptcha from 'vue-recaptcha'

export default {
  name: 'IssueForm',
  props: {
    givenBathroomId: {
      type: Number,
      default: -1
    },
    givenMenstrualProductType: {
      type: Number,
      default: -1
    }
  },
  components: {VueRecaptcha},

  data () {
    return {
      selectedCategory: 'Maintenance Issue',
      email: null,
      subject: null,
      bathroomId: this.givenBathroomId,
      captchaResponse: null,
      description: null,
      categories: [],
      isLoading: false,
      validationError: false,
      validationErrorPopup: false,
      captchaError: false,
      serverError: false,
      templateSelectToggle: true,
      selectedTemplate: 'None',
      templates: []
    }
  },
  methods: {
    getItemShortageTemplate: function (item) {
      return {
        subject: item.charAt(0).toUpperCase() + item.substr(1) + ' shortage/no ' + item,
        description: 'There is a shortage of/no ' + item + ' in this bathroom.'
      }
    },
    getGraffitiTemplate: function () {
      return {
        subject: 'Graffiti',
        description: 'There is graffiti in this bathroom that needs removal.'
      }
    },
    getUnsanitaryTemplate: function () {
      return {
        subject: 'Unsanitary Conditions',
        description: 'This bathroom needs to be cleaned ASAP due to unsanitary conditions.'
      }
    },
    getBrokenItemTemplate: function (item) {
      return {
        subject: item.charAt(0).toUpperCase() + item.substr(1) + ' Out of Order',
        description: 'One or more of the ' + item + 's in this bathroom is out of order.'
      }
    },
    getAllTemplates: function () {
      var templates = {
        'None': this.clearTemplate(),
        'Toilet Paper Shortage': this.getItemShortageTemplate('toilet paper'),
        'Soap Shortage': this.getItemShortageTemplate('soap'),
        'Graffiti': this.getGraffitiTemplate(),
        'Unsanitary Conditions': this.getUnsanitaryTemplate(),
        'Toilet Out of Order': this.getBrokenItemTemplate('toilet'),
        'Sink Out of Order': this.getBrokenItemTemplate('sink'),
        'Urinal Out of Order': this.getBrokenItemTemplate('urinal')
      }
      if (this.hasMenstrualProducts()) {
        templates['Menstrual Product Shortage'] = this.getItemShortageTemplate('menstrual products')
      }
      return templates
    },
    getTemplateList: function () {
      return Object.keys(this.getAllTemplates())
    },
    hasMenstrualProducts: function () {
      return this.givenMenstrualProductType !== null && Number(this.givenMenstrualProductType) !== -1
    },
    setTemplate: function (subject, description) {
      this.subject = subject
      this.description = description
    },
    clearTemplate: function () {
      this.setTemplate(null, null)
    },
    setTemplateFromTemplateObject: function (template) {
      this.setTemplate(template.subject, template.description)
    },
    templateSelect: function () {
      if (this.selectedTemplate.valueOf() === 'None'.valueOf()) {
        this.clearTemplate()
      } else {
        this.setTemplateFromTemplateObject(this.getAllTemplates()[this.selectedTemplate.valueOf()])
      }
    },
    categorySelect: function () {
      if (this.selectedCategory.valueOf() === 'Maintenance Issue'.valueOf()) {
        this.templateSelectToggle = true
      } else {
        this.templateSelectToggle = false
      }
    },
    getCategoriesList: function () {
      this.categories = ['Maintenance Issue', 'Inaccurate Data']
    },
    getPostBody: function () {
      return {
        captcha: this.captchaResponse,
        email: this.email,
        category: this.selectedCategory,
        bathroomId: this.bathroomId,
        subject: this.subject,
        description: this.description
      }
    },
    validateBeforeSubmit: function () {
      this.$validator.validateAll().then((result) => {
        if (result) {
          this.submit()
        } else {
          this.validationErrorPopup = true
        }
      })
    },
    submit: function () {
      if (this.captchaResponse == null) {
        this.captchaError = true
        return
      }
      this.isLoading = true
      setTimeout(() => {
        this.isLoading = false
      }, 10 * 1000)
      axios
        .post('/api/issueForm/submitIssue', this.getPostBody())
        .then((response) => {
          this.$router.push('/feedbackSubmitted')
        })
        .catch((err) => {
          this.serverError = true
          console.error(err)
          this.resetCaptcha()
        })
    },
    onCaptchaVerified: function (response) {
      this.captchaResponse = response
    },
    resetCaptcha: function () {
      this.captchaResponse = null
    }
  },
  mounted: function () {
    this.getCategoriesList()
    this.templates = this.getTemplateList()
  }
}
</script>

<style scoped>
</style>
