package edu.epis.sisga.controller;

import edu.epis.sisga.dao.IAccesoDao;
import edu.epis.sisga.dao.IEgresadoDao;
import edu.epis.sisga.dao.IRoleDao;
import edu.epis.sisga.dao.IUsuarioDao;
import edu.epis.sisga.entities.*;
import edu.epis.sisga.payload.JwtAuthenticationResponse;
import edu.epis.sisga.payload.LoginRequest;
import edu.epis.sisga.payload.SignUpRequest;
import edu.epis.sisga.security.JwtTokenProvider;
import edu.epis.sisga.services.IUserService;
import edu.epis.sisga.util.RestResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IUsuarioDao usuarioDao;

    @Autowired
    private IRoleDao roleDao;

    @Autowired
    private IAccesoDao accesoDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private IUserService userService;

    @Autowired
    private IEgresadoDao egresadoDao;
 

    private static final Log LOGGER = LogFactory.getLog(AuthController.class);

    @PostMapping("/signin")
    public JwtAuthenticationResponse authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        LOGGER.info(" PARAMETROS DE LOGUEO: <<<<<<<>>>>>> '"+ loginRequest.toString() + "'");
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );

            User user = this.userService.getPersonaByUsuario(loginRequest.getUsernameOrEmail());

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = tokenProvider.generateToken(authentication);

        if(jwt != null){
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            Collection<? extends GrantedAuthority> rol = userDetails.getAuthorities();

            List<Menu> menus = new ArrayList<>();

            for (GrantedAuthority roles : rol) {
                menus = this.accesoDao.findAllByRol(String.valueOf(roles));
            }
            if (rol.toString().equalsIgnoreCase("[EGRES]")){
                Egresado eg = egresadoDao.findByIdpersonaLong(user.getPersona().getIdpersona());
                return new JwtAuthenticationResponse(HttpStatus.OK.value(),"Sesión de inicio correcto egresado",jwt, userDetails.getUsername(),userDetails.getAuthorities(), user.getPersona().getNombres(),user.getPersona().getIdpersona(),eg.getEstado(), menus);
            }
            return new JwtAuthenticationResponse(HttpStatus.OK.value(),"Sesión de inicio correcto",jwt, userDetails.getUsername(),userDetails.getAuthorities(), user.getPersona().getNombres(),user.getPersona().getIdpersona(), menus);
        }
        return new JwtAuthenticationResponse(HttpStatus.UNAUTHORIZED.value(),"Credenciales invalidas o usuario no registrado");
        }

    @PostMapping("/signup")
    public RestResponse registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {

        LOGGER.info(" PARAMETROS DE LOGUEO: <<<<<<<>>>>>> '"+ signUpRequest.toString() + "'");

        if (usuarioDao.existsByUsername(signUpRequest.getUsername())) {
            return new RestResponse(HttpStatus.BAD_REQUEST.value(),"Fail -> Username is already taken!");
        }

        // Creating user's account
        User user = new User(signUpRequest.getUsername(),passwordEncoder.encode(signUpRequest.getPassword()),signUpRequest.getIdpersona());

        Long strRoles = signUpRequest.getIdrole();

        Set<Role> roles = new HashSet<>();

                Role adminRole = this.roleDao.findByIdrol(strRoles);

                roles.add(adminRole);

        user.setRoles(roles);
        usuarioDao.save(user);

//        String subject = "REGISTRO SATISFACTORIO ";
//        String body = "Estimada(o) " + signUpRequest.getIdpersona().getNombres() + ", "+ signUpRequest.getIdpersona().getApellidos()+
//                "\n Bienvenido al Sistema de Gestión Administrativa EPIS (SISGA - EPIS): " +
//                "\n de la Universidad Nacional de San Cristóbal de Huamanga " +
//                "\n\n TUS CREDENCIALES DE ACCESO SON: " +
//                "\n Usuario: " + signUpRequest.getUsername()+
//                "\n Contraseña : " + signUpRequest.getPassword();
//
//        mailService.sendMail("hever.fernandez@unsch.edu.pe",signUpRequest.getIdpersona().getCorreo(),subject,body);


        return new RestResponse(HttpStatus.OK.value(),"User registered successfully!");
    }
}
