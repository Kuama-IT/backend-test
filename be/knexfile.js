module.exports = {
  development: {
    client: 'pg',
    connection: {
      host: 'users-db',
      user: 'accountsUser',
      password: 'accountsPassword',
      database: 'accounts',
      port: 5444,
    },
  },
};
