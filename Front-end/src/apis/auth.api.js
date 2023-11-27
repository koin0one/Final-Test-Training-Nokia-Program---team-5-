import http from '@utils/http';

export const URL_LOGIN = 'login';
export const URL_REGISTER = 'register';
export const URL_LOGOUT = 'logout';
export const URL_REFRESH_TOKEN = 'refresh-access-token';

const authApi = {
  registerAccount: function (body) {
    return http.post(URL_REGISTER, body);
  },
  login: function (body) {
    return http.post(URL_LOGIN, body);
  },
  logout: function () {
    return http.post(URL_LOGOUT);
  },
};

export default authApi;
