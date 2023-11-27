export const config = {
    baseUrl: 'be-url',
    maxSizeUploadAvatar: 1048576, // bytes
    EXPIRE_ACCESS_TOKEN: 60 * 60 * 24, // 1 day
    EXPIRE_REFRESH_TOKEN: 60 * 60 * 24 * 160 // 160 days
  }

Object.freeze(config);
