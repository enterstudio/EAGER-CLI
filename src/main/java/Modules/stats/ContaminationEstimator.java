/*
 * Copyright (c) 2016. EAGER-CLI Alexander Peltzer
 * This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package Modules.stats;

import IO.Communicator;
import Modules.AModule;
import com.google.common.io.Files;
import java.util.Map;

/**
 * Created by peltzer on 01/12/15.
 */
public class ContaminationEstimator extends AModule {



    public ContaminationEstimator(Communicator c) {
        super(c);
    }

    @Override
    public void setProcessEnvironment (Map <String, String> env) {
        if ( !this.communicator.isUsesystemtmpdir() ) {
          AModule.setEnvironmentForParameterReplace (env,
                                                     "TMPDIR",
                                                     getOutputfolder() + System.getProperty ("file.separator") + ".tmp");
        }
    }

    @Override
    public void setParameters() {
        this.outputfile = this.inputfile;
        String prepend = "contDeam --library " + this.communicator.getSchmutzi_library_type() + " --out " + getOutputfolder()+"/contDeam/outputdeam " + this.getInputfile().get(0);
        String[] tmp = new String[]{"/bin/sh", "-c", "mkdir -p " + getOutputfolder() + "/contDeam && "+ prepend};
        this.parameters = tmp;
    }







    @Override
    public String getOutputfolder() {
        return this.communicator.getGUI_resultspath()+"/5-DeDup";
    }

    @Override
    public String getModulename(){
        return super.getModulename();
    }


}
