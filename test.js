import server from './index.js';
import supertest from 'supertest';
const requestWithSupertest = supertest(server);

describe('Wrong Endpoints', () => {

  it("Won't GET /", async () => {
    const res = await requestWithSupertest.get('/');
      expect(res.status).toEqual(404);
  });
  it("Won't GET /drinks", async () => {
    const res = await requestWithSupertest.get('/drinks');
      expect(res.status).toEqual(400);
  });
  it("Won't GET /drinks?type=", async () => {
    const res = await requestWithSupertest.get('/drinks');
      expect(res.status).toEqual(400);
  });

});


describe('Categories Endpoint', () => {

  it('GET /drinks/categories should show all drink categories', async () => {
    const res = await requestWithSupertest.get('/drinks/categories');
      expect(res.status).toEqual(200);
      expect(res.type).toEqual(expect.stringContaining('json'));
      expect(res.body).toContain('Shot');      
  });

});


describe('Drink type Endpoint', () => {

  it('GET /drinks?type=shot should show all shot drink', async () => {
    const res = await requestWithSupertest.get('/drinks?type=shot');
      expect(res.status).toEqual(200);
      expect(res.type).toEqual(expect.stringContaining('json'));      
      expect(res.body.length).toBeGreaterThan(0);  //todo: check if drink is shot type
  });

  it("GET /drinks?type=sho should return empty array because category doesn't exixt", async () => {
    const res = await requestWithSupertest.get('/drinks?type=sho');
      expect(res.status).toEqual(200);
      expect(res.type).toEqual(expect.stringContaining('json'));      
      expect(res.body.length).toBe(0);  
  });

});


describe('Drink keyword Endpoint', () => {

  it('GET /drinks?name=spritz should show all spritz drink', async () => {
    const res = await requestWithSupertest.get('/drinks?name=spritz');
      expect(res.status).toEqual(200);
      expect(res.type).toEqual(expect.stringContaining('json'));      
      expect(res.body[0].name).toEqual(expect.stringContaining('Spritz'));  //todo: check if all drink name contains spritz
  });

  it("GET /drinks?name= should return empty array because category doesn't exixt", async () => {
    const res = await requestWithSupertest.get('/drinks?name=');
      expect(res.status).toEqual(400);
  });

});