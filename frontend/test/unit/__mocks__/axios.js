module.exports = {
  get: jest.fn(() => Promise.resolve({ data: ['1'] })),
  post: jest.fn(() => Promise.resolve({ data: '2' }))
}
