class Toplevel(BaseWidget, Wm):
    """Toplevel widget, e.g. for dialogs."""
    def __init__(self, master=None, cnf={}, **kw):
        """Construct a toplevel widget with the parent MASTER.

        Valid resource names: background, bd, bg, borderwidth, class,
        colormap, container, cursor, height, highlightbackground,
        highlightcolor, highlightthickness, menu, relief, screen, takefocus,
        use, visual, width."""
        if kw:
            cnf = _cnfmerge((cnf, kw))
        extra = ()
        for wmkey in ['screen', 'class_', 'class', 'visual',
                  'colormap']:
            if wmkey in cnf:
                val = cnf[wmkey]
                # TBD: a hack needed because some keys
                # are not valid as keyword arguments
                if wmkey[-1] == '_': opt = '-'+wmkey[:-1]
                else: opt = '-'+wmkey
                extra = extra + (opt, val)
                del cnf[wmkey]
        BaseWidget.__init__(self, master, 'toplevel', cnf, {}, extra)
        root = self._root()
        self.iconname(root.iconname())
        self.title(root.title())
        self.protocol("WM_DELETE_WINDOW", self.destroy)
