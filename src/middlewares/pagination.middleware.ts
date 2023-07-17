const paginationMiddleware = (req, res, next) => {
    const { page, limit } = req.query;

    if (page && limit) {
        const skip = (+page - 1) * +limit;
        const take = +limit;
        res.locals.pagination = { skip, take };
    }

    next();
};

export default paginationMiddleware;
